<template>
  <tr class="user-row text-middle">
    <td class="text-middle">
      <img style="width: 50px; height: 50px; border-radius: 4px" src="assets/images/default_avatar.png"/>
    </td>
    <td class="text-middle">{{ user.username }}</td>
    <td class="text-middle">{{ user.firstName + ' ' + user.lastName }}</td>
    <td class="text-middle">{{ user.email }}</td>
    <td class="text-middle">{{ user.role }}</td>
    <td class="text-middle">KPI22</td>
    <td class="text-middle">

      <button class="btn btn-sm user-action-btn user-action-btn-resetpassword">
        <span class="fa fa-key"></span>
      </button>
      <button class="btn btn-sm user-action-btn user-action-btn-lock">
        <span class="fa fa-ban"></span>
      </button>
      <button class="btn btn-sm user-action-btn user-action-btn-edit">
        <span class="fa fa-pencil"></span>
      </button>
      <delete-user-button v-bind:user="user"></delete-user-button>
    </td>
  </tr>
</template>

<script>

  import $ from 'jquery';
  import { mapActions } from 'vuex';
  import DeleteUserButton from './DeleteUserButton';

  export default {
    components: { DeleteUserButton },
    name: 'userRow',
    props: ['user'],
    methods: mapActions([
      'deleteUser',
    ]),
    mounted() {
      $('.user-action-btn-lock').tooltip({ placement: 'auto bottom', title: 'Lock User' });
      $('.user-action-btn-edit').tooltip({ placement: 'auto bottom', title: 'Edit User Profile' });
      $('.user-action-btn-resetpassword').tooltip({ placement: 'auto bottom', title: 'Reset User Password' });
    },
  };
</script>
