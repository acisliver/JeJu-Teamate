const path = require('path')
module.exports = {
    outputDir: path.resolve(__dirname, "../src/main/resources/static    "),

    devServer: {
        proxy: {
            '/api' : {
                target: 'http://localhost:9000',
                ws: true,
                changedOrigin: true,
            },
        }
    },

    transpileDependencies: [
      'vuetify'
    ],
    chainWebpack: config => {
        const svgRule = config.module.rule("svg");
        svgRule.uses.clear();
        svgRule.use("vue-svg-loader").loader("vue-svg-loader");
    }
}
