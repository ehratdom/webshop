import { addNewProductInCart, getSCfromUser, getSCfromUsers } from '@/api/users';
import { User } from '@/model/user';
import { onMounted, ref } from 'vue';
import { stringifyQuery } from 'vue-router';

export function useUser() {

    const user = ref<User[]>([]);

    const getUser = async () => {
        try {
            user.value = await getSCfromUser();
        } catch (error) {
            console.log(error); // FIXME: Errorhandling
        }
    }

    onMounted(getUser);

    return {
        user
    }
}

export function useUsers() {

    const users = ref<User[]>([]);

    const getUsers = async () => {
        try {
            users.value = await getSCfromUsers();
        } catch (error) {
            console.log(error); // FIXME: Errorhandling
        }
    }

    onMounted(getUsers);

    return {
        users
    }
}

export function addProductInCart() {

    const users = ref<User[]>([]);

    const NewProductInCart = ref<User>({loginName:"user", shoppingCart:"10"});

    const getUsers = async () => {
        try {
            // add the new todo and update the list of all todos afterwards
            await addNewProductInCart(NewProductInCart.value);
            getUsers();
        } catch (error) {
            console.log(error); // FIXME: Errorhandling
        }
    }

    onMounted(getUsers);

    return {
        users
    }
}

