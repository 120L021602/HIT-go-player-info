<script>
import { storeToRefs } from "pinia";
import { useStore } from "../stores/store.js";
import { useTranslationStore } from "../stores/translation";

export default {
  setup() {
    const store = useStore();
    const { t } = storeToRefs(useTranslationStore());
    return { store, t };
  },

  mounted() {},

  data() {
    return {};
  },

  methods: {
    onMenuSelect(index) {
      switch (index) {
        case "0":
          this.store.type = "adminCreate";
          break;
        case "1":
          this.store.type = "adminLogin";
          break;
        case "2":
          this.store.type = "addPlayer";
          break;
        case "3":
          this.store.type = "queryPlayer";
          break;
        case "4":
          this.store.type = "playerMatch";
          break;
        case "5":
          this.store.type = "updatePlayer";
          break;
        case "6":
          this.store.type = "deletePlayer";
          break;
      }
    }
  }
};
</script>

<template>
  <el-menu default-active="4" class="menu" @select="onMenuSelect">
    <el-menu-item index="0">
      <el-icon><User /></el-icon>
      <span>{{ t.adminCreate }}</span>
    </el-menu-item>
    <el-menu-item index="1">
      <el-icon><UserFilled /></el-icon>
      <span>{{ t.adminLogin }}</span>
    </el-menu-item>
    <el-menu-item index="2">
      <el-icon><CirclePlus /></el-icon>
      <span>{{ t.addPlayer }}</span>
    </el-menu-item>
    <el-menu-item index="3">
      <el-icon><Search /></el-icon>
      <span>{{ t.queryPlayer }}</span>
    </el-menu-item>
    <el-menu-item index="4">
      <el-icon><Tickets /></el-icon>
      <span>{{ t.playerMatch }}</span>
    </el-menu-item>
    <el-menu-item index="5" v-show="this.store.isAdmin === true">
      <el-icon><EditPen /></el-icon>
      <span>{{ t.updatePlayer }}</span>
    </el-menu-item>
    <el-menu-item index="6" v-show="this.store.isAdmin === true">
      <el-icon><Delete /></el-icon>
      <span>{{ t.deletePlayer }}</span>
    </el-menu-item>
  </el-menu>
</template>

<style scoped>
.menu {
  width: 250px;
  border-right: 1px solid #eee;
}
</style>
