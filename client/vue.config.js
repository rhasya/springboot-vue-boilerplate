module.exports = {
  transpileDependencies: [
    'vuetify'
  ],
  devServer: {
    proxy: {
      '^/api': {
        target: 'http://localhost:8081',
        changeOrigin: true,
      },
      '^/check': {
        target: 'http://localhost:8081',
        changeOrigin: true,
      },
    }
  }
}
