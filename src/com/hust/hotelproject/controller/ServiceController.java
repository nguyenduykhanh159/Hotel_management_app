package com.hust.hotelproject.controller;

import java.util.List;

import com.hust.hotelproject.model.dao.ServiceDao;
import com.hust.hotelproject.model.dto.ServiceDto;
import com.hust.hotelproject.model.entity.Service;

public class ServiceController {
	private ServiceDao serviceDao;
	
	public ServiceController() {
            this.serviceDao = new ServiceDao();
	}
	
	public List<Service> returnAllService() {
            return serviceDao.getAllService();
	}
	
	public List<Service> findService(String name) {
            return serviceDao.findService(name);
	}
        
        public boolean insertService(Service service) {
            return serviceDao.insertService(service);
            
        }
        
        public void deleteService(String serviceId) {
            serviceDao.deleteService(serviceId);
        }
}
