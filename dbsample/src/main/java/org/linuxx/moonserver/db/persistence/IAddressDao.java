package org.linuxx.moonserver.db.persistence;

import java.util.List;

public interface IAddressDao {
	List<AddressEntity> fetch(String id);
}
