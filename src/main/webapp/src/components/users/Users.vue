<template>
  <div class="panel ">
    <div class="panel-heading">
      <div class="page-header">
        <a href="../users.html" class="h3 color-indigo">Users</a>
      </div>

      <div class="col-xs-12 col-sm-6 col-md-4 ">
        <button id="addUserBtn" type="button" class="btn btn-md btn-kpi-default panel-heading-control"><span
          class="fa fa-user-plus "></span>&nbsp; Add User
        </button>
        <button v-on:click="getUsers" type="button" class="btn btn-md btn-kpi-default panel-heading-control"><span
          class="fa fa-refresh "></span>&nbsp; Refresh
        </button>
      </div>

      <div class="col-xs-12 col-sm-6 col-md-8 ">
        <div
          class="input-group input-group-md col-xs-12 col-sm-12 col-md-6 pull-right panel-heading-control">
          <input v-model="searchUsers" type="text" class="form-control kpi-maincolor-bordered " name="username"
                 placeholder="Search for users...">
          <div class="input-group-btn">
            <button type="button" class="btn btn-md background-color-indigo"><span
              class="fa fa-search"></span></button>
          </div>
        </div>
      </div>
      <div class="clearfix"></div>
    </div>

    <div class="panel-body table-responsive">
      <table class="table table-hover user-table">
        <thead>
        <tr>
          <th class="col-lg-1 col-md-1 col-sm-1"></th>
          <th class="col-lg-2 col-md-2 col-sm-2">
            <a href="#">
              Username
            </a>
          </th>

          <th class="col-lg-2 col-md-2 col-sm-2">
            <a href="#">
              Full Name
            </a>
          </th>
          <th class="col-lg-2 col-md-2 col-sm-2"><a href="#">
            Email
          </a></th>
          <th class="col-lg-1 col-md-1 col-sm-1"><a href="#">Role
          </a></th>
          <th class="col-lg-2 col-md-2 col-sm-2">Project</th>
          <th class="col-lg-2 col-md-2 co2-sm-2">Action</th>
        </tr>
        </thead>
        <paginate name="users" :list="filteredUsers" :per="userPerPage" tag="tbody">
          <user-row v-for="user in paginated('users')" :key="user.username" v-bind:user="user"></user-row>
        </paginate>
      </table>
    </div>

    <div id="panel-footer" class="panel-footer">
      <div class="pagination pull-left">
        <div class="pull-left color-indigo" style="padding-top: 5px;">
          Entities per page: &nbsp; &nbsp;
        </div>
        <div class="pull-left">
          <select v-model="userPerPage" class="select form-control">
            <option v-for="option in userPerPageOptions">{{ option }}</option>
          </select>
        </div>
      </div>
      <paginate-links for="users" :classes="{'ul': ['pagination', 'pull-right' ,'kpi-maincolor-bordered']}"
                      :show-step-links="true" :hide-single-page="true"></paginate-links>
      <div class="clearfix"></div>
    </div>
    <add-user-modal></add-user-modal>
  </div>
</template>
<script>

  import $ from 'jquery';
  import { mapGetters, mapActions } from 'vuex';
  import userRow from './UserRow';
  import addUserModal from './AddUserModal';

  function searchCondition(query, ...properties) {
    for (let i = 0; i < properties.length; i += 1) {
      if (properties[i].includes(query)) return true;
    }
    return false;
  }

  export default {
    name: 'users',
    data() {
      return {
        paginate: ['users'],
        userPerPage: 10,
        userPerPageOptions: [5, 10, 25, 50, 100],
        searchUsers: '',
      };
    },
    components: {
      userRow,
      addUserModal,
    },
    computed: {
      filteredUsers() {
        return this.users.filter(user => searchCondition(this.searchUsers, user.username,
          user.firstName, user.lastName, user.email));
      },
      ...mapGetters({
        users: 'allUsers',
      }),
    },
    methods: mapActions([
      'getUsers',
    ]),
    created() {
      this.$store.dispatch('getUsers');
    },
    mounted() {
      $('#addUserBtn').click(() => {
        $('#addUserDialog').modal({
          backdrop: 'static',
          keyboard: false,
        });
        $('#userDialog_roleBox').prop('selectedIndex', -1);
        $('#userDialog_projectBox').prop('selectedIndex', -1);
      });
    },
  };
</script>

