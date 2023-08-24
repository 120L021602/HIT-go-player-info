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

  methods: {}
};
</script>

<template>
  <div
    class="comment-wrapper"
    v-show="this.store.success === true && this.store.type === 'playerInfo'"
  >
    <el-text class="comment" size="large">{{ t.comment }}{{ this.store.comment }}</el-text>
  </div>
</template>

<style scoped>
.comment-wrapper {
  height: 100px;
  width: calc(100vw)-180px;
  background-color: #f0f2f5;
}

.comment {
  font-size: larger;
}
</style>
