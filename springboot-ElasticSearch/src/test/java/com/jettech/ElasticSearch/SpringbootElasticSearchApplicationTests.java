package com.jettech.ElasticSearch;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jettech.ElasticSearch.bean.Article;
import com.jettech.ElasticSearch.bean.Book;
import com.jettech.ElasticSearch.repository.BookRepository;

import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootElasticSearchApplicationTests {

	@Autowired
	JestClient jestClient;
	
	@Autowired
	private BookRepository bookRepository;
	
	
	//使用jest索引
	@Test
	public void contextLoads() {
		//1，给ES中索引（保存）
		Article article = new Article();
		article.setId(1);
		article.setAuthor("张三");
		article.setTitle("西域记");
		article.setContent("Hello World!");
		//构建一个索引
		Index build = new Index.Builder(article).index("jettech").type("news").build();
		
		try {
			//执行
			jestClient.execute(build);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	//使用springboot-data-elasticsearch
	@Test
	public void bookTest() {
/*		Book book = new Book();	//在book实体类上标注book存储的索引位置和类型
		book.setId(1);
		book.setBookName("西游记");
		book.setAuthor("吴承恩");
		bookRepository.index(book);*/
		List<Book> books = bookRepository.findByBookNameLike("游记");
		for (Book book : books) {
			System.out.println(book);
		}
	}
	
	//使用jest搜索
	@Test
	public void search() {
		//构建查询表达式
		String Json="{\n" +
				"    \"query\" : {\n" +
				"        \"match\" : {\n" +
				"            \"content\" : \"hello\"\n" +
				"        }\n" +
				"    }\n" +
				"}";
		//构建搜索功能
		Search search = new Search.Builder(Json).addIndex("jettech").addType("news").build();
		
		try {
			//执行
			SearchResult result = jestClient.execute(search);
			System.out.println(result.getJsonString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
