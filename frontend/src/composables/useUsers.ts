import { getSCfromUser, getSCfromUsers } from '@/api/users';
import { User } from '@/model/user';
import { onMounted, ref } from 'vue';

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