package com.syncleus.ferma.index;

import com.syncleus.ferma.index.field.FieldMap;

public abstract class AbstractIndexDefinition implements ElementIndexDefinition {

	protected String postfix;

	protected String name;

	protected boolean unique = false;

	protected FieldMap fields;

	@Override
	public boolean isUnique() {
		return unique;
	}

	@Override
	public FieldMap getFields() {
		return fields;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getPostfix() {
		return postfix;
	}

}