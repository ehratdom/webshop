<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-title>Produkte</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true">
      <ion-header collapse="condense">
        <ion-toolbar>
          <ion-title size="large">Produkte</ion-title>
        </ion-toolbar>
      </ion-header>
      <ion-list>
        <ion-row>
          <ion-item :key="product" v-for="product in products">
            <ion-grid>
              <ion-col>
                {{ product.name }}
              </ion-col>

              <ion-img
                style="width: 500px; height: 500px"
                :src="product.img"
              ></ion-img>

              <ion-button color="success">Add to cart</ion-button>
            </ion-grid>
          </ion-item>
        </ion-row>
      </ion-list>
    </ion-content>
  </ion-page>
</template>

<script lang="ts">
import {
  IonTitle,
  IonHeader,
  IonCol,
  IonRow,
  IonGrid,
  IonItem,
  IonList,
  IonButton,
  IonToolbar,
  IonImg,
  IonContent,
  IonPage,
} from "@ionic/vue";
//import { pin, walk, warning, wifi, wine } from "ionicons/icons";
import { defineComponent } from "vue";
import axios from "axios";
import { useProducts } from "@/composables/useProducts";

export default defineComponent({
  name: "Product",
  components: {
    IonTitle,
    IonHeader,
    IonCol,
    IonRow,
    IonGrid,
    IonItem,
    IonList,
    IonButton,
    IonToolbar,
    IonImg,
    IonContent,
    IonPage,
  },
  setup() {
    const { products } = useProducts();
    return { products };
  },
});
</script>
