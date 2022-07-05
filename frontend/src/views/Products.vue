<template>
  <ion-card>
    <ion-card-header>
      <ion-card-title>Card Title</ion-card-title>
    </ion-card-header>

    <ion-card-content>
      Keep close to Nature's heart.
    </ion-card-content>

  <ion-img :src="item.src"></ion-img>

    <ion-button
      color="success">Add to cart</ion-button>
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
});
</script>
