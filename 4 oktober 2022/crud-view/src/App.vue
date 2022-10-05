<template>
  <div id="app">
    <Employees />
  </div>
</template>

<script>
import tutorials from "./components/Employees.vue"

export default {
  name: "App",
  components: {
    tutorials,
  },
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
