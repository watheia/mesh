package com.gentics.mesh.core.data;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import com.gentics.madl.traversal.RawTraversalResult;
import com.gentics.mesh.context.BulkActionContext;
import com.gentics.mesh.context.InternalActionContext;
import com.gentics.mesh.core.data.node.Node;
import com.gentics.mesh.core.data.page.Page;
import com.gentics.mesh.core.data.relationship.GraphPermission;
import com.gentics.mesh.core.rest.common.GenericRestResponse;
import com.gentics.mesh.core.rest.common.PermissionInfo;
import com.gentics.mesh.core.rest.event.MeshElementEventModel;
import com.gentics.mesh.core.rest.event.role.PermissionChangedEventModelImpl;
import com.gentics.mesh.core.rest.user.UserReference;
import com.gentics.mesh.core.rest.user.UserResponse;
import com.gentics.mesh.etc.config.MeshOptions;
import com.gentics.mesh.event.EventQueueBatch;
import com.gentics.mesh.graphdb.spi.Database;
import com.gentics.mesh.madl.frame.EdgeFrame;
import com.gentics.mesh.madl.frame.ElementFrame;
import com.gentics.mesh.madl.tp3.mock.GraphTraversal;
import com.gentics.mesh.madl.traversal.TraversalResult;
import com.gentics.mesh.parameter.PagingParameters;
import com.gentics.mesh.parameter.value.FieldsSet;
import com.syncleus.ferma.ClassInitializer;
import com.syncleus.ferma.FramedGraph;
import com.syncleus.ferma.TEdge;
import com.syncleus.ferma.VertexFrame;
import com.syncleus.ferma.traversals.EdgeTraversal;
import com.syncleus.ferma.traversals.VertexTraversal;
import com.tinkerpop.blueprints.Vertex;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.AuthProvider;

/**
 * Create mocked user for node migrations.
 */
public class NodeMigrationUser implements MeshAuthUser {

	@Override
	public void setName(String name) {
	}

	@Override
	public String getName() {
		return "node_migration";
	}

	@Override
	public UserReference transformToReference() {
		return null;
	}

	@Override
	public UserResponse transformToRestSync(InternalActionContext ac, int level, String... languageTags) {
		return null;
	}

	@Override
	public String getETag(InternalActionContext ac) {
		return null;
	}

	@Override
	public String getAPIPath(InternalActionContext ac) {
		return null;
	}

	@Override
	public void setUuid(String uuid) {

	}

	@Override
	public void setCachedUuid(String uuid) {

	}

	@Override
	public String getUuid() {
		return null;
	}

	@Override
	public Vertex getVertex() {
		return null;
	}

	@Override
	public void delete(BulkActionContext context) {

	}

	@Override
	public void applyPermissions(EventQueueBatch batch, Role role, boolean recursive, Set<GraphPermission> permissionsToGrant,
		Set<GraphPermission> permissionsToRevoke) {

	}

	@Override
	public boolean update(InternalActionContext ac, EventQueueBatch batch) {
		return true;
	}

	@Override
	public User setUsername(String string) {
		return this;
	}

	@Override
	public User setReferencedNode(Node node) {
		return this;
	}

	@Override
	public User setPasswordHash(String hash) {
		return this;
	}

	@Override
	public User setLastname(String lastname) {
		return this;
	}

	@Override
	public User setFirstname(String firstname) {
		return this;
	}

	@Override
	public User setEmailAddress(String email) {
		return this;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getUsername() {
		return "node_migration";
	}

	@Override
	public Iterable<? extends Role> getRolesViaShortcut() {
		return Collections.emptyList();
	}

	@Override
	public Page<? extends Role> getRolesViaShortcut(User user, PagingParameters params) {
		return null;
	}

	@Override
	public void updateShortcutEdges() {
	}

	@Override
	public String getRolesHash() {
		return null;
	}

	@Override
	public List<? extends Role> getRoles() {
		return Collections.emptyList();
	}

	@Override
	public Node getReferencedNode() {
		return null;
	}

	@Override
	public String getPasswordHash() {
		return null;
	}

	@Override
	public String getLastname() {
		return null;
	}

	@Override
	public Page<? extends Group> getGroups(User user, PagingParameters params) {
		return null;
	}

	@Override
	public TraversalResult<? extends Group> getGroups() {
		return new TraversalResult<>(() -> Collections.emptyIterator());
	}

	@Override
	public boolean isAdmin() {
		return false;
	}

	@Override
	public void setAdmin(boolean flag) {

	}

	@Override
	public String getFirstname() {
		return null;
	}

	@Override
	public String getEmailAddress() {
		return null;
	}

	@Override
	public User enable() {
		return this;
	}

	@Override
	public User disable() {
		return this;
	}

	@Override
	public User addGroup(Group group) {
		return this;
	}

	@Override
	public io.vertx.ext.auth.User isAuthorized(String authority, Handler<AsyncResult<Boolean>> resultHandler) {
		return null;
	}

	@Override
	public io.vertx.ext.auth.User clearCache() {
		return null;
	}

	@Override
	public JsonObject principal() {
		return null;
	}

	@Override
	public void setAuthProvider(AuthProvider authProvider) {
	}

	@Override
	public void writeToBuffer(Buffer buffer) {
	}

	@Override
	public int readFromBuffer(int pos, Buffer buffer) {
		return 0;
	}

	@Override
	public Vertex getElement() {
		return null;
	}

	@Override
	public <T> T addFramedEdge(String label, VertexFrame inVertex, ClassInitializer<T> initializer) {
		return null;
	}

	@Override
	public <T> T addFramedEdge(String label, VertexFrame inVertex, Class<T> kind) {
		return null;
	}

	@Override
	public <T> T addFramedEdgeExplicit(String label, VertexFrame inVertex, ClassInitializer<T> initializer) {
		return null;
	}

	@Override
	public <T> T addFramedEdgeExplicit(String label, VertexFrame inVertex, Class<T> kind) {
		return null;
	}

	@Override
	public TEdge addFramedEdge(String label, VertexFrame inVertex) {
		return null;
	}

	@Override
	public VertexTraversal<?, ?, ?> out(String... labels) {
		return null;
	}

	@Override
	public <T extends ElementFrame> TraversalResult<T> out(String label, Class<T> clazz) {
		return null;
	}

	@Override
	public <T extends EdgeFrame> TraversalResult<? extends T> outE(String label, Class<T> clazz) {
		return null;
	}

	@Override
	public <T extends ElementFrame> TraversalResult<T> in(String label, Class<T> clazz) {
		return null;
	}

	@Override
	public <T extends EdgeFrame> TraversalResult<? extends T> inE(String label, Class<T> clazz) {
		return null;
	}

	@Override
	public VertexTraversal<?, ?, ?> in(String... labels) {
		return null;
	}

	@Override
	public EdgeTraversal<?, ?, ?> outE(String... labels) {
		return null;
	}

	@Override
	public EdgeTraversal<?, ?, ?> inE(String... labels) {
		return null;
	}

	@Override
	public void linkOut(VertexFrame vertex, String... labels) {

	}

	@Override
	public void linkIn(VertexFrame vertex, String... labels) {

	}

	@Override
	public void unlinkOut(VertexFrame vertex, String... labels) {

	}

	@Override
	public void unlinkIn(VertexFrame vertex, String... labels) {

	}

	@Override
	public void setLinkOut(VertexFrame vertex, String... labels) {

	}

	@Override
	public VertexTraversal<?, ?, ?> traversal() {
		return null;
	}

	@Override
	public com.google.gson.JsonObject toJson() {
		return null;
	}

	@Override
	public <T> T reframe(Class<T> kind) {
		return null;
	}

	@Override
	public <T> T reframeExplicit(Class<T> kind) {
		return null;
	}

	@Override
	public Object getId() {
		return null;
	}

	@Override
	public Set<String> getPropertyKeys() {
		return null;
	}

	@Override
	public void remove() {

	}

	@Override
	public FramedGraph getGraph() {
		return null;
	}

	@Override
	public <T> T getGraphAttribute(String key) {
		return null;
	}

	@Override
	public <T> T getProperty(String name) {
		return null;
	}

	@Override
	public <T> T getProperty(String name, Class<T> type) {
		return null;
	}

	@Override
	public void setProperty(String name, Object value) {

	}

	@Override
	public Class<?> getTypeResolution() {
		return null;
	}

	@Override
	public void setTypeResolution(Class<?> type) {

	}

	@Override
	public void removeTypeResolution() {
	}

	@Override
	public VertexTraversal<?, ?, ?> v() {
		return null;
	}

	@Override
	public EdgeTraversal<?, ?, ?> e() {
		return null;
	}

	@Override
	public EdgeTraversal<?, ?, ?> e(Object... ids) {
		return null;
	}

	@Override
	public <T extends RawTraversalResult<?>> T traverse(Function<GraphTraversal<Vertex, Vertex>, GraphTraversal<?, ?>> traverser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSingleLinkInTo(com.gentics.mesh.madl.frame.VertexFrame vertex, String... labels) {

	}

	@Override
	public void setSingleLinkOutTo(com.gentics.mesh.madl.frame.VertexFrame vertex, String... labels) {

	}

	@Override
	public void setUniqueLinkInTo(com.gentics.mesh.madl.frame.VertexFrame vertex, String... labels) {

	}

	@Override
	public void setUniqueLinkOutTo(com.gentics.mesh.madl.frame.VertexFrame vertex, String... labels) {

	}

	@Override
	public User getCreator() {
		return null;
	}

	@Override
	public User getEditor() {
		return null;
	}

	@Override
	public User setResetToken(String token) {
		return this;
	}

	@Override
	public String getResetToken() {
		return null;
	}

	@Override
	public boolean isForcedPasswordChange() {
		return false;
	}

	@Override
	public User setForcedPasswordChange(boolean force) {
		return null;
	}

	@Override
	public Long getResetTokenIssueTimestamp() {
		return null;
	}

	@Override
	public User setResetTokenIssueTimestamp(Long timestamp) {
		return null;
	}

	@Override
	public String getAPIKeyTokenCode() {
		return null;
	}

	@Override
	public User setAPITokenId(String code) {
		return null;
	}

	@Override
	public User setAPITokenIssueTimestamp() {
		return null;
	}

	@Override
	public User setAPITokenIssueTimestamp(Long timestamp) {
		return null;
	}

	@Override
	public void fillCommonRestFields(InternalActionContext ac, FieldsSet fields, GenericRestResponse model) {
	}

	@Override
	public TraversalResult<? extends Role> getRolesWithPerm(GraphPermission perm) {
		return null;
	}

	@Override
	public PermissionInfo getRolePermissions(InternalActionContext ac, String roleUuid) {
		return null;
	}

	@Override
	public String getElementVersion() {
		return null;
	}

	@Override
	public MeshElementEventModel onCreated() {
		return null;
	}

	@Override
	public MeshElementEventModel onUpdated() {
		return null;
	}

	@Override
	public MeshElementEventModel onDeleted() {
		return null;
	}

	@Override
	public PermissionChangedEventModelImpl onPermissionChanged(Role role) {
		return null;
	}

	@Override
	public void fillPermissionChanged(PermissionChangedEventModelImpl model, Role role) {
	}

	@Override
	public MeshAuthUser toAuthUser() {
		return null;
	}

	@Override
	public Vertx vertx() {
		return null;
	}

	@Override
	public Database db() {
		return null;
	}

	@Override
	public MeshOptions options() {
		return null;
	}

}