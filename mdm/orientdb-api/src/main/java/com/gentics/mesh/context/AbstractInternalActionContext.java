package com.gentics.mesh.context;

import static com.gentics.mesh.core.rest.error.Errors.error;
import static io.netty.handler.codec.http.HttpResponseStatus.INTERNAL_SERVER_ERROR;

import com.gentics.mesh.core.data.branch.HibBranch;
import com.gentics.mesh.core.data.project.HibProject;
import com.gentics.mesh.core.data.user.MeshAuthUser;
import com.gentics.mesh.core.rest.common.RestModel;
import com.gentics.mesh.core.rest.error.GenericRestException;

import io.netty.handler.codec.http.HttpResponseStatus;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

/**
 * Abstract class for internal action context.
 */
public abstract class AbstractInternalActionContext extends AbstractActionContext implements InternalActionContext {

	private static final String SKIP_LOCK_DATA_KEY = "SKIP_LOCK";

	/**
	 * Field which will store the body model.
	 */
	private Object bodyModel = null;

	@Override
	public void send(RestModel restModel, HttpResponseStatus status) {
		send(restModel.toJson(), status);
	}

	@Override
	public <T> Handler<AsyncResult<T>> errorHandler() {
		Handler<AsyncResult<T>> handler = t -> {
			if (t.failed()) {
				fail(t.cause());
			}
		};
		return handler;
	}

	@Override
	public void setBody(Object model) {
		this.bodyModel = model;
	}

	@Override
	public <T> T fromJson(Class<?> classOfT) throws GenericRestException {
		if (bodyModel != null) {
			return (T) bodyModel;
		}
		return super.fromJson(classOfT);
	}

	@Override
	public boolean isSkipWriteLock() {
		return this.data().containsKey(SKIP_LOCK_DATA_KEY);
	}

	@Override
	public InternalActionContext skipWriteLock() {
		this.data().put(SKIP_LOCK_DATA_KEY, true);
		return this;
	}

	@Override
	public boolean isAdmin() {
		MeshAuthUser user = getUser();
		if (user == null) {
			return false;
		}
		return user.isAdmin();
	}

}
