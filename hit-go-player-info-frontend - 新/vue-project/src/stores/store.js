import { defineStore } from "pinia";
export const useStore = defineStore("main", {
  state: () => ({
    type: "playerMatch",
    isAdmin: false,
    success: false,
    name: "",
    gender: "",
    yearOfBirth: "",
    school: "",
    department: "",
    major: "",
    level: "",
    nativePlace: "",
    yhAccount: "",
    comment: "",
    playerMatchList: []
  }),
  getters: {
    infoList: (state) => {
      const infoKeys = [
        "name",
        "gender",
        "yearOfBirth",
        "nativePlace",
        "school",
        "department",
        "major",
        "level",
        "yhAccount"
      ];

      return infoKeys.map((key) => ({
        info: key,
        detail: state[key]
      }));
    }
  }
});
