package com.gentics.mesh.core.endpoint.role;

import com.gentics.mesh.context.BulkActionContext;
import com.gentics.mesh.context.InternalActionContext;
import com.gentics.mesh.core.data.Role;
import com.gentics.mesh.core.data.page.TransformablePage;
import com.gentics.mesh.core.data.relationship.GraphPermission;
import com.gentics.mesh.core.db.Tx;
import com.gentics.mesh.core.rest.role.RoleResponse;
import com.gentics.mesh.core.verticle.handler.CRUDActions;
import com.gentics.mesh.event.EventQueueBatch;
import com.gentics.mesh.parameter.PagingParameters;

public class RoleCrudActions implements CRUDActions<Role, RoleResponse> {

	@Override
	public Role load(Tx tx, InternalActionContext ac, String uuid, GraphPermission perm, boolean errorIfNotFound) {
		return tx.data().roleDao().loadObjectByUuid(ac, uuid, perm, errorIfNotFound);
	}

	@Override
	public TransformablePage<? extends Role> loadAll(Tx tx, InternalActionContext ac, PagingParameters pagingInfo) {
		return tx.data().roleDao().findAll(ac, pagingInfo);
	}

	@Override
	public Role create(Tx tx, InternalActionContext ac, EventQueueBatch batch, String uuid) {
		return tx.data().roleDao().create(ac, batch, uuid);
	}

	@Override
	public boolean update(Tx tx, Role role, InternalActionContext ac, EventQueueBatch batch) {
		return tx.data().roleDao().update(role, ac, batch);
	}

	@Override
	public void delete(Tx tx, Role role, BulkActionContext bac) {
		tx.data().roleDao().delete(role, bac);
	}

	@Override
	public RoleResponse transformToRestSync(Tx tx, Role element, InternalActionContext ac) {
		return tx.data().roleDao().transformToRestSync(element, ac, 0);
	}

}