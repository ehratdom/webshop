<template>
  <ion-card>
    <ion-card-header>
      <ion-card-title>{{ products }}</ion-card-title>
    </ion-card-header>

    <ion-card-content> Keep close to Nature's heart. </ion-card-content>

    <ion-img
      src="https://media-exp1.licdn.com/dms/image/C4E03AQGeQE40cqtcpg/profile-displayphoto-shrink_200_200/0/1652624287356?e=1658361600&v=beta&t=oEZxHOsVmvFzShttWhaOgFyXzPw6Xm9jPp1jmmjNPTI"
    ></ion-img>

    <ion-button color="success">Add to cart</ion-button>
  </ion-card>
</template>

<script>
import {
  IonCard,
  IonCardContent,
  IonCardSubtitle,
  IonCardTitle,
  IonIcon,
  IonItem,
  IonLabel,
} from "@ionic/vue";
import { pin, walk, warning, wifi, wine } from "ionicons/icons";
import { defineComponent } from "vue";
import axios from "axios";

export default defineComponent({
  Components: {
    IonCard,
    IonCardContent,
    IonCardSubtitle,
    IonCardTitle,
    IonIcon,
    IonItem,
    IonLabel,
  },
  setup() {
    return { pin, walk, warning, wifi, wine };
  },

  data() {
    return {
      products: [],
    };
  },

  mounted() {
    this.getProducts();
  },

  methods: {
    async getProducts() {
      const config = {
        withCredentials: true,
      };
      try {
        const response = await axios.get("http://localhost:8080/api/products", config);
        this.products = response.data;
      } catch (error) {
        return error;
      }
    },
  },
});
</script>
