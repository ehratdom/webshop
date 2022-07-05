<template>
  <ion-page>
    <ion-tabs>
      <ion-router-outlet></ion-router-outlet>
      <ion-tab-bar slot="bottom">
        <ion-tab-button tab="products" href="/tabs/products">
          <ion-icon :icon="flash" />
          <ion-label>Products</ion-label>
        </ion-tab-button>
          
        <ion-tab-button tab="projects" href="/tabs/projects">
          <ion-icon :icon="cart" />
          <ion-label>Cart</ion-label>
        </ion-tab-button>
        
      </ion-tab-bar>
    </ion-tabs>
  </ion-page>
</template>

<script lang="ts">
import { IonTabBar, IonTabButton, IonTabs, IonLabel, IonIcon, IonPage, IonRouterOutlet } from '@ionic/vue';
import { flash, cart, send } from 'ionicons/icons';

export default {
  name: 'Tabs',
  components: { IonLabel, IonTabs, IonTabBar, IonTabButton, IonIcon, IonPage, IonRouterOutlet },
  setup() {
    return {
      flash, 
      cart, 
      send,
    }
  }
}
</script>