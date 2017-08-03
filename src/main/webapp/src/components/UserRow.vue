<template>
  <tr class="user-row text-middle">
    <td class="text-middle">
      <img style="width: 50px; height: 50px; border-radius: 4px" src="images/avatar.png"/>
    </td>
    <td class="text-middle">{{ user.username }}</td>
    <td class="text-middle">{{ user.firstName + ' ' + user.lastName }}</td>
    <td class="text-middle">{{ user.email }}</td>
    <td class="text-middle">{{ user.role }}</td>
    <td class="text-middle">KPI22</td>
    <td class="text-middle">

      <button class="btn btn-sm  user-action-btn">
        <span class="glyphicon glyphicon-repeat"></span>
      </button>
      <button class="btn btn-sm  user-action-btn">
        <span class="glyphicon glyphicon-ban-circle"></span>
      </button>
      <button class="btn btn-sm  user-action-btn">
        <span class="glyphicon glyphicon-edit"></span>
      </button>
      <button v-on:click="deleteUser(user)" class="btn btn-sm  user-action-btn">
        <span class="glyphicon glyphicon-trash"></span>
      </button>
    </td>
  </tr>
</template>

<script>

  import { mapActions } from 'vuex';

  export default {
    name: 'userRow',
    props: ['user'],
    methods: mapActions([
      'deleteUser',
    ]),
  };
</script>

