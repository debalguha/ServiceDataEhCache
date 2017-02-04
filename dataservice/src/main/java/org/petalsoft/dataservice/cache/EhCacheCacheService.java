package org.petalsoft.dataservice.cache;

import java.util.Collection;
import java.util.stream.Collectors;

import org.petalsoft.dataservice.model.Instrument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;
import net.sf.ehcache.search.Query;
import net.sf.ehcache.search.Results;

@Service
public class EhCacheCacheService implements CacheService{
	
	@Autowired
	private Cache cache;

	public void cacheObject(Comparable<?> obj, String cacheKey) {
		cache.put(new Element(cacheKey, obj));
	}

	public Collection<?> lookupFor(String property, Object value, boolean isPagingEnabled) {
		Query query = cache.createQuery().addCriteria(cache.getSearchAttribute(property).eq(value)).includeValues();
		Results results = isPagingEnabled ? query.maxResults(20).execute() : query.execute();
		return results.all().stream().map(result -> (Instrument)result.getValue()).collect(Collectors.toList());
	}
	public Collection<?> lookupAll(boolean isPagingEnabled) {
		return cache.createQuery().maxResults(20).includeValues().execute().all().stream().map(result -> (Instrument)result.getValue()).collect(Collectors.toList());
	}

}
