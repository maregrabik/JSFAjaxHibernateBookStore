package DAO;

import entity.Authors;

public class AuthorsDAO extends BaseDAOimpl<Authors> {

	public AuthorsDAO(Class<Authors> type) {
		super(type);
	}
	public AuthorsDAO(){
		this(Authors.class);
	}
}
