package com.jettech.ElasticSearch.repository;


import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.jettech.ElasticSearch.bean.Book;

public interface BookRepository extends ElasticsearchRepository<Book, Integer>{
	
	//自定义方法
	public List<Book> findByBookNameLike(String bookName);
}
