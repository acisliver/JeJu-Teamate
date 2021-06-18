
export default {
    namespaced: true,
    state: {
        isLogin: false,
        userInfo: {
            name: '',
            role: '',
            nickName: '',
        },
    },
    getters:{

    },
    mutations: {
        loginSuccess(state, userName) {
            state.isLogin = true
            state.isLoginError = false
            state.userInfo.userName = userName
        },
        loginError(state) {
            state.isLoginError = true
            state.isLogin = false
        },
        logout(state) {
            state.isLogin = false
            state.isLoginError = false
            localStorage.removeItem("token")
        },
    },
    actions: {
        loginAction({commit}, statusOk, userName){
            if(statusOk === 200){
                commit("loginSuccess", userName)
            }
            else if(statusOk === 204 ){
                commit('loginError')
            }
        },
        logoutAction({commit}) {
            commit('logout')
        },
    }
}