import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.AlreadyExistsException;
import ru.netology.NotFoundException;
import ru.netology.Product;
import ru.netology.ShopRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NotFoundExceptionTest {

    @Test
    public void shouldTestNotFindId() {
        ShopRepository shopRepository = new ShopRepository();
        shopRepository.add(new Product(1, "Хлеб", 100));

        Assertions.assertThrows(NotFoundException.class, () -> {
            shopRepository.removeById(2);

        });


    }

    @Test
    public void shouldTestFindId() {
        ShopRepository shopRepository = new ShopRepository();
        shopRepository.add(new Product(1, "Хлеб", 100));
        Product product = shopRepository.findById(1);
        Assertions.assertEquals(1, product.getId());

    }
    @Test

    public void shouldTestAlreadyExists(){
        ShopRepository shopRepository = new ShopRepository();
        Product product1 = new Product(1, "Хлеб", 100);
        Product product2 = new Product(2, "Молоко", 50);
        try{
            shopRepository.add(product1);
            shopRepository.add(product2);
            shopRepository.add(new Product(1,"Масло",80));

        } catch (AlreadyExistsException e) {
            // Проверяем, что сообщение исключения соответствует ожидаемому
            Assertions.assertEquals("Product with ID 1 already exists.", e.getMessage());
        }



    }
    @Test

    public void shouldTestDoesNotAlreadyExists(){
        ShopRepository shopRepository = new ShopRepository();
        Product product1 = new Product(1, "Хлеб", 100);
        Product product2 = new Product(2, "Молоко", 50);
        Product newProduct = new Product(3, "Масло", 80);
            shopRepository.add(product1);
            shopRepository.add(product2);
            shopRepository.add(newProduct);
        Product[] allProducts = shopRepository.findAll();

        // Ожидаемый массив содержит добавленные товары
        Product[] expectedArray = new Product[]{product1, product2, newProduct};


        Assertions.assertArrayEquals(expectedArray,allProducts);
    }
}

