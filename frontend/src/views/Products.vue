<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-title>Products</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true">
      <ion-header collapse="condense">
        <ion-toolbar>
          <ion-title size="large">Products</ion-title>
        </ion-toolbar>
      </ion-header>
      <ion-grid>
        <ion-card :key="product" v-for="product in products">
          <ion-img height="100px" width="100px" :src="product.img"></ion-img>
          <ion-card-header>
            <ion-row>
              <ion-col>
                <ion-card-title>{{ product.name }}</ion-card-title>
              </ion-col>
              <ion-col>
                <ion-button float-right color="success">
                  <ion-icon :icon="cart" />
                  <ion-label>Add to cart</ion-label>
                </ion-button>
              </ion-col>
            </ion-row>
            <ion-card-subtitle>Price: {{ product.price }} </ion-card-subtitle>
          </ion-card-header>
          <ion-card-content>
            {{ product.description }}
          </ion-card-content>
        </ion-card>
      </ion-grid>
    </ion-content>
  </ion-page>
</template>

<script lang="ts">
import {
  IonTitle,
  IonHeader,
  IonCol,
  IonRow,
  IonCard,
  IonCardContent,
  IonCardSubtitle,
  IonCardTitle,
  IonButton,
  IonToolbar,
  IonImg,
  IonContent,
  IonPage,
  IonCardHeader,
  IonGrid,
  IonIcon,
} from "@ionic/vue";
import { cart } from "ionicons/icons";
import { defineComponent } from "vue";
import { useProducts } from "@/composables/useProducts";

export default defineComponent({
  name: "Product",
  components: {
    IonTitle,
    IonHeader,
    IonCol,
    IonRow,
    IonCard,
    IonCardContent,
    IonCardSubtitle,
    IonCardTitle,
    IonButton,
    IonToolbar,
    IonImg,
    IonContent,
    IonPage,
    IonCardHeader,
    IonGrid,
    IonIcon,
  },
  setup() {
    const { products } = useProducts();
    return { products, cart };
  },
});
</script>