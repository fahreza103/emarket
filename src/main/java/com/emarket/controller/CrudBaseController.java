package com.emarket.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.emarket.object.requestbody.CriteriaManagedResource;


public class CrudBaseController<T> {
	public ResponseEntity<Page<? extends T>> doSearch(CriteriaManagedResource searchRequest,Map<String, String> allRequestParams, PageRequest request,
			HttpServletRequest servletRequest) throws Exception {
		return new ResponseEntity<Page<? extends T>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Page<? extends T>> doSearch(Map<String, String> allRequestParams, PageRequest request,
			HttpServletRequest servletRequest) throws Exception {
		return new ResponseEntity<Page<? extends T>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Page<Map<String, String>>> doMultiSelect(Map<String, String> allRequestParams,
			PageRequest request, HttpServletRequest servletRequest) throws Exception {
		return new ResponseEntity<Page<Map<String, String>>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<T> doGet(long id, HttpServletRequest servletRequest) throws Exception {
		return new ResponseEntity<T>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<T> doPost(T item, HttpServletRequest servletRequest) throws Exception {
		return new ResponseEntity<T>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<T> doPut(long id, T item, HttpServletRequest servletRequest) throws Exception {
		return new ResponseEntity<T>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<T> doPatch(long id, T item, HttpServletRequest servletRequest) throws Exception {
		return new ResponseEntity<T>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<T> doDelete(long id, HttpServletRequest servletRequest) throws Exception {
		return new ResponseEntity<T>(HttpStatus.NOT_IMPLEMENTED);
	}

	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<? extends T>> get(@RequestParam Map<String, String> allRequestParams,
			@RequestParam(value = "page", defaultValue = "0") int pageIndex,
			@RequestParam(value = "size", defaultValue = "10") int size,
			@RequestParam(value = "order", defaultValue = "asc") String order,
			@RequestParam(value = "sort", defaultValue = "id") String sort, HttpServletRequest servletRequest)
			throws Exception {
		PageRequest request = new PageRequest(pageIndex, size, Direction.fromString(order), sort);

		return doSearch(allRequestParams, request, servletRequest);
	}

	@RequestMapping(value = "search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<? extends T>> search(
			@RequestBody(required = false) CriteriaManagedResource searchRequest,
			@RequestParam Map<String, String> allRequestParams,
			@RequestParam(value = "page", defaultValue = "0") int pageIndex,
			@RequestParam(value = "size", defaultValue = "10") int size,
			@RequestParam(value = "order", defaultValue = "asc") String order,
			@RequestParam(value = "sort", defaultValue = "id") String sort, HttpServletRequest servletRequest)
			throws Exception {
		PageRequest request = new PageRequest(pageIndex, size, Direction.fromString(order), sort);

		return doSearch(searchRequest,allRequestParams, request, servletRequest);
	}

	@RequestMapping(value = "select", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Map<String, String>>> multiSelect(@RequestParam Map<String, String> allRequestParams,
			@RequestParam(value = "page", defaultValue = "0") int pageIndex,
			@RequestParam(value = "size", defaultValue = "10") int size,
			@RequestParam(value = "order", defaultValue = "asc") String order,
			@RequestParam(value = "sort", defaultValue = "id") String sort, HttpServletRequest servletRequest)
			throws Exception {
		PageRequest request = new PageRequest(pageIndex, size, Direction.fromString(order), sort);

		return doMultiSelect(allRequestParams, request, servletRequest);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<T> get(@PathVariable long id, HttpServletRequest servletRequest) throws Exception {
		return doGet(id, servletRequest);
	}

	@RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<T> create(@RequestBody T item, HttpServletRequest servletRequest) throws Exception {

		return doPost(item, servletRequest);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<T> put(@PathVariable long id, @RequestBody T item, HttpServletRequest servletRequest)
			throws Exception {

		return doPut(id, item, servletRequest);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<T> patch(@PathVariable long id, @RequestBody T item, HttpServletRequest servletRequest)
			throws Exception {
		return doPatch(id, item, servletRequest);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<T> delete(@PathVariable long id, HttpServletRequest servletRequest) throws Exception {

		return doDelete(id, servletRequest);
	}
}
