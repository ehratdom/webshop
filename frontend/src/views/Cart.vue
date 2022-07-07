<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-title>Cart</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true">
      <ion-header collapse="condense">
        <ion-toolbar>
          <ion-title size="large">Cart</ion-title>
        </ion-toolbar>
      </ion-header>
      <ion-list>
        <ion-item :key="user" v-for="user in users">
          <ion-grid>
            <ion-row>
              <ion-col>Product-ID</ion-col>
              <ion-col>Amount</ion-col>
              <ion-col>Product</ion-col>
              <ion-col>Price</ion-col>
            </ion-row>
            <ion-row
              :key="productInCart"
              v-for="productInCart in user.shoppingCart.products">
              <ion-col>
                {{ productInCart.product.id  }}
              </ion-col>
              <ion-col>
                {{ productInCart.amount  }}
              </ion-col>
              <ion-col>
                {{ productInCart.product.name  }}                
              </ion-col>
              <ion-col>
               {{  productInCart.product.price  }}
              </ion-col>
            </ion-row>
            <ion-row>
              <ion-col> </ion-col>
              <ion-col> </ion-col>
              <ion-col> </ion-col>
              <ion-col>Total: {{ user.shoppingCart.totalPrice }} </ion-col>
            </ion-row>
          </ion-grid>
        </ion-item>
      </ion-list>
    </ion-content>
  </ion-page>
</template>

<script lang="ts">
import {
  IonPage,
  IonHeader,
  IonToolbar,
  IonTitle,
  IonContent,
  IonCol,
  IonRow,
  IonGrid,
  IonItem,
  IonList,
} from "@ionic/vue";
import { defineComponent } from "vue";
import { useUsers } from "@/composables/useUsers";

export default defineComponent({
  name: "Todo",
  components: {
    IonHeader,
    IonToolbar,
    IonTitle,
    IonContent,
    IonPage,
    IonCol,
    IonRow,
    IonGrid,
    IonItem,
    IonList,
  },
  setup() {
    const { users } = useUsers();
    return { users };
  },
});
</script>