import { deleteProductInCart } from '@/api/productsincart';
import { ProductinCart } from '@/model/productincart';
import { onMounted, ref } from 'vue';


export function useProductsinCart() {

    const productincart = ref<ProductinCart[]>([]);

    const getProductsinCart = async () => {
        try {
            productincart.value = await deleteProductInCart();
        } catch (error) {
            console.log(error); // FIXME: Errorhandling
        }
    }

    onMounted(getProductsinCart);

    return {
        deleteProductInCart
    }
}
