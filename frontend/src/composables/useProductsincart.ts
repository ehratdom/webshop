import { deleteProductInCart } from '@/api/productsincart';
import { ProductinCart } from '@/model/productincart';
import { onMounted, ref } from 'vue';


export function useProductsInCart() {
    let id: number;

    const productincart = ref<ProductinCart[]>([]);

    
    const getProductsInCart = async () => {
        try {
            await deleteProductInCart(id);
        } catch (error) {
            console.log(error); // FIXME: Errorhandling
        }
    }

    onMounted(getProductsInCart);

    return {
        deleteProductInCart
    }
}
