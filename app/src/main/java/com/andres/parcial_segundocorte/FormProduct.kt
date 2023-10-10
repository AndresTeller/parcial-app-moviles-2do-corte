package com.andres.parcial_segundocorte

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class FormProduct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_product)

        // Obtener referencias a los elementos de la interfaz de usuario
        val etCode = findViewById<EditText>(R.id.etCode)
        val etProductName = findViewById<EditText>(R.id.etProductName)
        val etPrice = findViewById<EditText>(R.id.etPrice)
        val etDiscount = findViewById<EditText>(R.id.etDiscount)
        val btnAddProduct = findViewById<Button>(R.id.btnAddProduct)
        val btnCancelProduct = findViewById<Button>(R.id.btnCancelProduct)


        // Configurar acción para el botón "Add Movie"
        btnAddProduct.setOnClickListener {
            val code = etCode.text.toString()
            val productName = etProductName.text.toString()
            val price = etPrice.text.toString()
            val discount = etDiscount.text.toString()

            val product = Product(code, productName, price, discount)

            // Obtener una instancia de MovieRepository
            val productRepository = ProductRepository(this)

            // Llamar a la función para agregar la película a la base de datos
            productRepository.addProduct(product)

            // Mostrar un mensaje de confirmación
            Toast.makeText(this, "Product added successfully!", Toast.LENGTH_SHORT).show()



            // Leer la película recién agregada y mostrar sus detalles

            val addedProduct = productRepository.getProduct(code)
            if (addedProduct != null) {
                val movieDetailsMessage = "Added Movie Details:\n" +
                        "Code: ${addedProduct.code}\n" +
                        "Product name: ${addedProduct.productName}\n" +
                        "Price: ${addedProduct.price}\n" +
                        "Discount: ${addedProduct.discount}"
                Toast.makeText(this, movieDetailsMessage, Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Failed to retrieve added product details.", Toast.LENGTH_LONG).show()
            }


        }


        // Configurar acción para el botón "Cancel Movie"
        btnCancelProduct.setOnClickListener {
            etCode.text.clear()
            etProductName.text.clear()
            etPrice.text.clear()
            etDiscount.setSelection(0)
        }





    }
}