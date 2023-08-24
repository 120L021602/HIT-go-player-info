import { ref } from "vue";
import { defineStore } from "pinia";
import zhCn from "../translations/zhcn.json";
import en from "../translations/en.json";

export const useTranslationStore = defineStore("translation", () => {
  const t = ref(zhCn);

  function switchTranslation(locale) {
    switch (locale) {
      case "ZH_CN":
        t.value = zhCn;
        break;
      case "EN":
        t.value = en;
        break;
    }
  }

  return { t, switchTranslation };
});
