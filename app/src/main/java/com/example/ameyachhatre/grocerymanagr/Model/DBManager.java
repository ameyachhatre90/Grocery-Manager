package com.example.ameyachhatre.grocerymanagr.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.ameyachhatre.grocerymanagr.Product;
import java.util.List;

// Manages the database by defining different methods for the CRUD (Create, Read, Update and Delete) operations
public class DBManager {
    private Context context;
    private DBOpenHelper dbOpenHelper;  // public class DBOpenHelper extends SQLiteOpenHelper
    private SQLiteDatabase db;
    private ProductDAO productDAO;

    // Constructor for DBManager
    public DBManager(Context context) {
        this.context = context;
        dbOpenHelper = new DBOpenHelper(this.context);      // Create an instance of DBOpenHelper
        db = dbOpenHelper.getWritableDatabase(); //Create &/or open a db that will be used for reading & writing.
        productDAO = new ProductDAO(db);
    }
    // Save a product item in DB
    public long saveProduct(Product productItem) {
        return this.productDAO.save(productItem);
    }

    // Update a product item in DB //@param productItem - specific item // @return updated product = true, false
    public boolean updateProduct(Product productItem) {
        return this.productDAO.update(productItem);
    }

    // Delete a product item in DB // @param productItem - specific item
    // @return product deleted = true, else false
    public boolean deleteProduct(Product productItem) {
        return this.productDAO.delete(productItem);
    }

    // Get a product by ID from DB // @param id - product ID
    // @return Specific Product entry
    public Product get(long id) {
        return this.productDAO.get(id);
    }

    // Get all product items as a list from DB // @return List
    public List<Product> getAllProducts() {
        return this.productDAO.getAll();
    }

    public List<Product> getAllStockedProducts() {
        return this.productDAO.getAllStocked();
    }
}
