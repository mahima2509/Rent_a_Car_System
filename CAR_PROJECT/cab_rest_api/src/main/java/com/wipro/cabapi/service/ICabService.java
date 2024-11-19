package com.wipro.cabapi.service;

import java.util.List;

import com.wipro.cabapi.dto.CabDTO;
import com.wipro.cabapi.dto.CabDetails;
import com.wipro.cabapi.dto.CabDriverVO;
import com.wipro.cabapi.dto.Driver;
import com.wipro.cabapi.entity.Cab;

public interface ICabService {

    public Cab addCab(CabDTO cabDTO);
    
    public CabDTO getCabById(int cabId);
        
    public List<CabDetails> getAllCabs();
    
//    public CabDriverVO getCabAndDriverById(int cabId);

	void deleteById(int cabId);

	Cab updateCab(CabDTO cabDTO);

   // public void updateDriverByCab(Driver driver);

	/*
	 * public Cab updateCab(CabDTO cabDTO);
	 * 
	 * public Cab deleteCab(CabDTO cabDTO);
	 * 
	 * void deleteCabById(int cabId);
	 */
}
