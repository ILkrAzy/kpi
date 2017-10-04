<template>
  <div id="addUserDialog" class="modal fade" role="dialog">
    <div class="modal-dialog modal-lg kpi-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Add new User</h4>
        </div>

        <div class="modal-body ">

          <div class="row">
            <div class="col-md-10 ">
              <form class="form-horizontal" @submit.prevent="addUser">
                <fieldset>
                  <!-- Form Name -->
                  <!--<legend>User profile form requirement</legend>-->
                  <!-- Text input-->
                  <div class="form-group">
                    <label class="col-md-4 control-label" for="userDialog_usernameTxt">Username</label>
                    <div class="col-md-6">
                      <input v-model="user.username" id="userDialog_usernameTxt" name="Username" type="text"
                             placeholder="Username" class="form-control input-md" required>
                    </div>
                  </div>

                  <div class="form-group">
                    <label class="col-md-4 control-label" for="userDialog_firstNameTxt">First Name</label>
                    <div class="col-md-6">
                      <input v-model="user.firstName" id="userDialog_firstNameTxt" name="First Name" type="text"
                             placeholder="First Name" class="form-control input-md" required>
                    </div>
                  </div>

                  <div class="form-group">
                    <label class="col-md-4 control-label" for="userDialog_lastNameTxt">Last Name</label>
                    <div class="col-md-6">
                      <input v-model="user.lastName" id="userDialog_lastNameTxt" name="Last Name" type="text"
                             placeholder="Last Name"
                             class="form-control input-md" required>
                    </div>
                  </div>

                  <div class="form-group ">
                    <label class="col-md-4 control-label" for="userDialog_emailTxt">Email</label>
                    <div class="col-md-6">
                      <input v-model="user.email" id="userDialog_emailTxt" name="Date Of Birth" type="email"
                             placeholder="Email"
                             class="form-control input-md" required>
                    </div>
                  </div>

                  <div class="form-group ">
                    <label class="col-md-4 control-label" for="userDialog_roleBox">Role</label>
                    <div class="col-md-6">
                      <select v-model="user.role" id="userDialog_roleBox" class="select form-control" required>
                        <option v-for="role in roles">{{ role }}</option>
                      </select>
                    </div>
                  </div>

                  <div class="form-group">
                    <label class="col-md-4 control-label"></label>
                    <div class="col-md-4">
                      <button id="userDialog_createBtn" type="submit"
                              class="btn btn-success" ><span
                        class="fa fa-save"></span>&nbsp;&nbsp;Save
                      </button>
                      &nbsp;
                      <button v-on:click="clear" id="userDialog_clearBtn" type="button" class="btn btn-danger"><span
                        class="glyphicon glyphicon-remove-sign"></span>&nbsp;&nbsp;Clear
                      </button>
                    </div>
                  </div>
                </fieldset>
              </form>
            </div>

          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

  import $ from 'jquery';
  import userApi from '../../api/user';
  import projectApi from '../../api/project';

  function newUser() {
    return {
      username: '',
      firstName: '',
      lastName: '',
      email: '',
      role: '',
      project: '',
    };
  }

  export default {
    name: 'adduser',
    data() {
      return {
        user: newUser(),
        roles: [],
        projects: [],
      };
    },
    methods: {
      addUser() {
        this.$store.dispatch('addUser', this.user);
        this.user = newUser();
        $('#addUserDialog').modal('toggle');
      },
      clear() {
        this.user = newUser();
      },
    },
    created() {
      const self = this;
      userApi.getRoles().then((roles) => {
        self.roles = roles.data;
      });
      projectApi.getProjects().then((projects) => {
        self.projects = projects.data;
      });
    },
  };
</script>

