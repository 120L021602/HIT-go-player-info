import {defineStore} from 'pinia'
export const useStore = defineStore('main', {
    state: () => ({
        type: 'playerMatch',
        isAdmin: false,
        success: false,
        name: '',
        gender: '',
        yearOfBirth: '',
        school: '',
        department: '',
        major: '',
        level: '',
        nativePlace: '',
        yhAccount: '',
        comment: '',
        playerMatchList: []
    })
})