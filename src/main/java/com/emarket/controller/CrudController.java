package com.emarket.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.emarket.entity.Generic;
import com.emarket.object.requestbody.CriteriaManagedResource;
import com.emarket.repository.CommonRepository;


public class CrudController <T extends Generic> extends CrudBaseController<T>{
	
	protected final CommonRepository<T, Long> repository;

	public CrudController(CommonRepository<T, Long> repository) {
		this.repository = repository;
	}
	
	@Override
	public ResponseEntity<Page<? extends T>> doSearch(CriteriaManagedResource searchRequest,Map<String, String> allRequestParams, PageRequest pageable,
			HttpServletRequest servletRequest) throws Exception {
//		SearchBuilder<? extends T> searchBuilder = searchBuilder(allRequestParams);
//
//		preSearch(searchBuilder, allRequestParams, servletRequest);
//
//		Page<? extends T> filteredPage = searchBuilder.include(includes()).doSearch(request, allRequestParams);
//
//		postSearch(filteredPage, allRequestParams);
		
		Page<? extends T> filteredPage = repository.findAll(pageable);

		return new ResponseEntity<Page<? extends T>>(filteredPage, HttpStatus.OK);
	}

	
	@Override
	public ResponseEntity<T> doGet(long id, HttpServletRequest servletRequest) throws Exception {
		T item = doGetById(id);
		if (item == null) {
			return new ResponseEntity<T>((T) null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<T>(item, HttpStatus.OK);
	}

	protected T doGetById(long id) throws Exception {
		Optional<T> result = repository.findById(id);

		if (result == null) {
			throw new Exception("Id not found.");
		}
		return result.get();
	}
	
	@Override
	public ResponseEntity<T> doPost(T item, HttpServletRequest servletRequest) throws Exception {
		beforePost(item);

		item.setId(0);
		T savedItem = doSave(item);

		afterPost(savedItem);

		return new ResponseEntity<T>(savedItem, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<T> doPatch(long id, T item, HttpServletRequest servletRequest) throws Exception {
		item.setId(id);

		beforePatch(item);
		// fetch and update parameter
		Optional<T> original = repository.findById(id);
		T originalObject = original.get();
		if (originalObject == null) {
			return new ResponseEntity<T>(originalObject, HttpStatus.NOT_FOUND);
		}

		performPatch(originalObject, item);

		T savedItem = doSave(originalObject);

		afterPatch(savedItem);

		return new ResponseEntity<T>(savedItem, HttpStatus.ACCEPTED);
	}
	
	protected T performPatch(T original, T request) {
		return original;
	}

	@Override
	public ResponseEntity<T> doPut(long id, T item, HttpServletRequest servletRequest) throws Exception {

		item.setId(id);

		beforePut(item);

		T savedItem = doSave(item);

		afterPut(savedItem);

		return new ResponseEntity<T>(savedItem, HttpStatus.ACCEPTED);
	}

	@Override
	public ResponseEntity<T> doDelete(long id, HttpServletRequest servletRequest) throws Exception {
		Optional<T> original = repository.findById(id);
		T originalObject = original.get();
		if (originalObject == null) {
			return new ResponseEntity<T>(originalObject, HttpStatus.NOT_FOUND);
		}

		beforeDelete(id);

		doDelete(originalObject);

		afterDelete(id);

		return new ResponseEntity<T>(HttpStatus.OK);
	}

	protected void doDelete(T original) throws Exception {

		// Hard delete
		original.setDeleted(true);
		original.setDeletedOn(new Date());

		repository.delete(original);

	};

	protected T doSave(T item) throws Exception {
		T savedItem = repository.save(item);
		return savedItem;
	}

	protected void beforePost(T body) throws Exception {
	};

	protected void afterPost(T body) throws Exception {
	};

	protected void beforePut(T body) throws Exception {
	};

	protected void afterPut(T body) throws Exception {
	};

	protected void beforePatch(T body) throws Exception {
	};

	protected void afterPatch(T body) throws Exception {
	};

	protected void beforeDelete(long id) throws Exception {
	};

	protected void afterDelete(long id) throws Exception {
	};
	
	protected List<String> includes() {
		return new ArrayList<>();
	}
}
