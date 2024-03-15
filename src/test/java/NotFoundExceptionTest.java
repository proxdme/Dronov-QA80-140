import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.NotFoundException;
import ru.netology.Product;
import ru.netology.ShopRepository;

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
}