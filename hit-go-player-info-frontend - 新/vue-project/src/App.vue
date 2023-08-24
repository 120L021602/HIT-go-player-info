<script setup>
import AsideComponent from "./components/Aside.vue";
import MainComponent from "./components/Main.vue";
import CommentComponent from "./components/Comment.vue";
import { useTranslationStore } from "./stores/translation";
import { storeToRefs } from "pinia";

const store = useTranslationStore();
const { t } = storeToRefs(store);
const { switchTranslation } = store;
const onLangDropdownCommand = (e) => {
  switchTranslation(e);
};
</script>

<template>
  <main class="main">
    <header class="header">
      <span class="header-title">{{ t.title }}</span>

      <el-dropdown class="lang-dropdown" @command="onLangDropdownCommand">
        <span class="lang">
          <el-icon class="lang-icon"><SwitchFilled /></el-icon>
          <span class="lang-text">Lang</span>
        </span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item command="ZH_CN">简体中文</el-dropdown-item>
            <el-dropdown-item command="EN">English</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </header>
    <div class="middle">
      <AsideComponent />
      <section class="content">
        <MainComponent />
        <CommentComponent />
      </section>
    </div>

    <footer class="footer">{{ t.credit }}</footer>
  </main>
</template>

<style scoped>
.main {
  width: max(1000px, 100vw);
  display: flex;
  flex-direction: column;
}

.header {
  position: relative;
  height: 70px;
  background-color: #409eff;
  box-shadow: 0 5px 10px 0 #d1d1d1;
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 300;
}

.header-title {
  font-size: 28px;
  color: white;
}

.lang-dropdown {
  position: absolute;
  right: 50px;
  color: white;
  cursor: pointer;
  user-select: none;
}

.lang {
  display: flex;
  align-items: center;
}

.lang-icon {
  font-size: 18px;
}

.lang-text {
  font-size: 15px;
}

.middle {
  display: flex;
  height: calc(100vh - 120px);
}

.content {
  width: 100%;
  display: flex;
  flex-direction: column;
}

.footer {
  height: 50px;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 15px;
  box-sizing: border-box;
  border-top: 1px solid #eee;
}
</style>
