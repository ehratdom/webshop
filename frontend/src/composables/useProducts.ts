import { getAllProducts } from '@/api/products';
import { Product } from '@/model/product';
import { onMounted, ref } from 'vue';

export function useProducts() {

    const products = ref<Product[]>([]);

    const getProducts = async () => {
        try {
            products.value = await getAllProducts();
        } catch (error) {
            console.log(error); // FIXME: Errorhandling
        }
    }

    onMounted(getProducts);

    return {
        getProducts
    }
}
