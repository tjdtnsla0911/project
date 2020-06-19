package com.cos.fruit.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.fruit.db.DBConn;
import com.cos.fruit.model.Product;



//싱글톤
//DAO
public class ProductRepository {
	
	private static final String TAG = "ProductRepository : ";
	private static ProductRepository instance = new ProductRepository();
	private ProductRepository() {}
	public static ProductRepository getInstance() {
		return instance;
	}
	
	private Connection conn =null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	
	
	
	public List<Product> findAll() {
	
		final String SQL = "SELECT * FROM product ORDER BY id ASC";
		List<Product> products = new ArrayList<>();
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			
			// 물음표 완성하기
			
			// while 돌려서 rs -> java 오브젝트에 집어넣기
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Product product = new Product(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("type"),
						rs.getInt("price"),
						rs.getInt("count")
				);
				products.add(product);
			}
			
			return products;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"findAll() : "+e.getMessage());
			
		} finally {
			DBConn.close(conn, pstmt ,rs);
		}
		
		return null;
	}
	public List<Product> PriceSortfindAll() {
		
		final String SQL = "SELECT * FROM product ORDER BY price DESC";
		List<Product> products = new ArrayList<>();
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			
			// 물음표 완성하기
			
			// while 돌려서 rs -> java 오브젝트에 집어넣기
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Product product = new Product(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("type"),
						rs.getInt("price"),
						rs.getInt("count")
				);
				products.add(product);
			}
			
			return products;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"PriceSortfindAll() : "+e.getMessage());
			
		} finally {
			DBConn.close(conn, pstmt ,rs);
		}
		
		return null;
	}
	public List<Product> SellSortfindAll() {
		
		final String SQL = "SELECT * FROM product ORDER BY count DESC";
		List<Product> products = new ArrayList<>();
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			
			// 물음표 완성하기
			
			// while 돌려서 rs -> java 오브젝트에 집어넣기
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Product product = new Product(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("type"),
						rs.getInt("price"),
						rs.getInt("count")
				);
				products.add(product);
			}
			
			return products;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"SellSortfindAll() : "+e.getMessage());
			
		} finally {
			DBConn.close(conn, pstmt ,rs);
		}
		
		return null;
	}
	
	public int deleteById(int itemId) {
		final String SQL ="DELETE FROM product WHERE id = ?";
		System.out.println(itemId);
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물음표 완성하기
			
			pstmt.setInt(1, itemId);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"deleteById : "+e.getMessage());
			
		} finally {
			DBConn.close(conn, pstmt);
		}
		
		return -1;
	}
}