package org.petalsoft.dataservice.cache;

import java.util.Collection;

public interface CacheService {
	void cacheObject(Comparable<?> obj, String cacheKey);
	Collection<?> lookupFor(String property, Object value, boolean isPagingEnabled);
	Collection<?> lookupAll(boolean isPagingEnabled);
}
