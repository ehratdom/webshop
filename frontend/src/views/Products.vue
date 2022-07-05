<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-title>Produkte</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true">
      <ion-card :key="product" v-for="product in products">
        <ion-card-header>
          <ion-card-title>{{ product.name }}</ion-card-title>
        </ion-card-header>

        <ion-card-content> kostet {{ product.price }} </ion-card-content>

        <ion-img style="width: 100px; height: 100px;"
          :src="product.img"
        ></ion-img>

        <ion-button color="success">Add to cart</ion-button>
      </ion-card>
    </ion-content>
  </ion-page>
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
        const response = await axios.get(
          "http://localhost:8080/api/products",
          config
        );
        this.products = response.data;
        console.log(this.products)
      } catch (error) {
        return error;
      }
    },
  },
});
</script>
