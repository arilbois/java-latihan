<template>
  <div class="container">
    <h1 class="text-center">tutorials List</h1>

    <table class="table table-striped">
      <thead>
        <tr>
          <th>tutorials Id</th>
          <th>tutorials description</th>
          <th>tutorials published</th>
          <th>tutorials title</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="tutorials in tutorials" v-bind:key="tutorials.id">
          <td>{{ tutorials.id }}</td>
          <td>{{ tutorials.description }}</td>
          <td>{{ tutorials.published }}</td>
          <td>{{ tutorials.title }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import tutorialservice from "../services/tutorialservice"

export default {
  name: "tutorials",
  data() {
    return {
      tutorials: [],
    }
  },
  methods: {
    gettutorials() {
      tutorialservice.gettutorials().then((response) => {
        this.tutorials = response.data
      })
    },
  },
  created() {
    this.gettutorials()
  },
}
</script>
