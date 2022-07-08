import { deleteProductInCart } from '@/api/productsincart';
import { ProductinCart } from '@/model/productincart';
import { onMounted, ref } from 'vue';


export function useProductsInCart() {

    

    const productincart = ref<ProductinCart[]>([]);
    const id = 0;
    
    const getProductsInCart = async () => {
        try {
            productincart.value = await deleteProductInCart(id);
        } catch (error) {
            console.log(error); // FIXME: Errorhandling
        }
    }

    onMounted(getProductsInCart);

    return {
        deleteProductInCart
    }
}