package org.petalsoft.dataservice.web;

import java.util.Collection;

import org.petalsoft.dataservice.cache.CacheService;
import org.petalsoft.dataservice.model.Instrument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataServiceController {
	@Autowired
	private CacheService cacheService;
	
	@RequestMapping("/init")
	public String doInit(){
		for(int i=0;i<7000000;i++)
			cacheService.cacheObject(new Instrument(new Long(i), "sample-ric.OQ".concat(String.valueOf(i)), "sample-isin".concat(String.valueOf(i)), "sample-sedol".concat(String.valueOf(i))), String.valueOf(i));
		return "Done";
	}
	
	@RequestMapping("/quorumListingId/{quorumListingId:.+}")
	public Collection<?> byQuorumListingId(@PathVariable("quorumListingId") String quorumListingId){
		return cacheService.lookupFor("quorumListingId", new Long(quorumListingId), true);
	}
	@RequestMapping("/ric/{ric:.+}")
	public Collection<?> byRic(@PathVariable("ric") String ric){
		return cacheService.lookupFor("ric", ric, true);
	}
	@RequestMapping("/sedol/{sedol:.+}")
	public Collection<?> bySedol(@PathVariable("sedol") String sedol){
		return cacheService.lookupFor("sedol", sedol, true);
	}
	@RequestMapping("/isin/{isin:.+}")
	public Collection<?> byIsin(@PathVariable("isin") String isin){
		return cacheService.lookupFor("isin", isin, true);
	}
	@RequestMapping("/all")
	public Collection<?> all(){
		return cacheService.lookupAll(true);
	}
}
