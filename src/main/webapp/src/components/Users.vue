<template>
  <div class="container " style="min-height: 100%;">
    <navbar></navbar>
    <div class="panel ">
      <div class="panel-heading">
        <div class="page-header">
          <a href="../users.html" class="h3 color-indigo">Users</a>
        </div>
        <div class="row">
          <div class="col-xs-12 col-sm-6 col-md-4">
            <button type="button" class="btn btn-md btn-indigo panel-heading-control"><span
              class="glyphicon glyphicon-plus"></span>&nbsp; Add User
            </button>
            <button type="button" class="btn btn-md btn-indigo panel-heading-control"><span
              class="glyphicon glyphicon-refresh"></span>&nbsp; Refresh
            </button>
          </div>

          <div class="col-xs-12 col-sm-6 col-md-8">
            <div
              class="input-group input-group-md col-xs-12 col-sm-12 col-md-6 pull-right panel-heading-control">
              <input type="text" class="form-control color-indigo-bordered" name="username"
                     placeholder="Search for users...">
              <div class="input-group-btn">
                <button type="button" class="btn btn-md background-color-indigo"><span
                  class=" glyphicon glyphicon-search"></span></button>
              </div>
            </div>
          </div>
        </div>
      </div>

      <div class="panel-body ">
        <table class="table table-hover user-table">
          <thead>
          <tr>
            <th class="col-lg-1 col-md-1 col-sm-1"></th>
            <th class="col-lg-2 col-md-2 col-sm-2">
              <a href="#">
                Username
                <span class="glyphicon glyphicon-triangle-bottom"></span>
              </a>
            </th>

            <th class="col-lg-2 col-md-2 col-sm-2">
              <a href="#">
                Full Name
                <span class="glyphicon glyphicon-triangle-bottom"></span>
              </a>
            </th>
            <th class="col-lg-2 col-md-2 col-sm-2"><a href="#">
              Email
              <span class="glyphicon glyphicon-triangle-bottom"></span>
            </a></th>
            <th class="col-lg-1 col-md-1 col-sm-1"><a href="#">Role
              <span class="glyphicon glyphicon-triangle-bottom"></span>
            </a></th>
            <th class="col-lg-2 col-md-2 col-sm-2">Project</th>
            <th class="col-lg-2 col-md-2 co2-sm-2">Action</th>
          </tr>
          </thead>
          <tbody>
          <tr class="user-row text-middle">
            <td class="text-middle">
              <img style="width: 50px; height: 50px; border-radius: 4px" src="images/avatar.png"/>
            </td>
            <td class="text-middle"><a href="#"> ddlanh</a></td>
            <td class="text-middle">Lanh Dang</td>
            <td class="text-middle">ddlanh@tma.com.vn</td>
            <td class="text-middle">Manager</td>
            <td class="text-middle">KPI22</td>
            <td class="text-middle">

              <button class="btn btn-sm  user-action-btn">
                <span class="glyphicon glyphicon-repeat"></span>
              </button>
              <button class="btn btn-sm  user-action-btn">
                <span class="glyphicon glyphicon-ban-circle"></span>
              </button>
              <button class="btn btn-sm  user-action-btn ">
                <span class="glyphicon glyphicon-edit"></span>
              </button>
              <button class="btn btn-sm  user-action-btn user-action-btn-delete" data-toggle="clickover">
                <span class="glyphicon glyphicon-trash"></span>
              </button>
            </td>
          </tr>
          <tr class="user-row text-middle">
            <td class="text-middle">
              <img style="width: 50px; height: 50px; border-radius: 4px" src="images/avatar.png"/>
            </td>
            <td class="text-middle"><a href="#"> ddlanh</a></td>
            <td class="text-middle">Lanh Dang</td>
            <td class="text-middle">ddlanh@tma.com.vn</td>
            <td class="text-middle">Manager</td>
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
              <button class="btn btn-sm  user-action-btn user-action-btn-delete">
                <span class="glyphicon glyphicon-trash"></span>
              </button>
            </td>
          </tr>
          <tr class="user-row text-middle">
            <td class="text-middle">
              <img style="width: 50px; height: 50px; border-radius: 4px" src="images/avatar.png"/>
            </td>
            <td class="text-middle"><a href="#"> ddlanh</a></td>
            <td class="text-middle">Lanh Dang</td>
            <td class="text-middle">ddlanh@tma.com.vn</td>
            <td class="text-middle">Manager</td>
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
              <button class="btn btn-sm  user-action-btn">
                <span class="glyphicon glyphicon-trash"></span>
              </button>
            </td>
          </tr>
          <tr class="user-row text-middle">
            <td class="text-middle">
              <img style="width: 50px; height: 50px; border-radius: 4px" src="images/avatar.png"/>
            </td>
            <td class="text-middle"><a href="#"> ddlanh</a></td>
            <td class="text-middle">Lanh Dang</td>
            <td class="text-middle">ddlanh@tma.com.vn</td>
            <td class="text-middle">Manager</td>
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
              <button class="btn btn-sm  user-action-btn">
                <span class="glyphicon glyphicon-trash"></span>
              </button>
            </td>
          </tr>
          <tr class="user-row text-middle">
            <td class="text-middle">
              <img style="width: 50px; height: 50px; border-radius: 4px" src="images/avatar.png"/>
            </td>
            <td class="text-middle"><a href="#"> ddlanh</a></td>
            <td class="text-middle">Lanh Dang</td>
            <td class="text-middle">ddlanh@tma.com.vn</td>
            <td class="text-middle">Manager</td>
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
              <button class="btn btn-sm  user-action-btn">
                <span class="glyphicon glyphicon-trash"></span>
              </button>
            </td>
          </tr>
          </tbody>
        </table>
      </div>

      <div class="panel-footer">
        <div class="row">
          <div class="pagination pull-left">
            <div class="pull-left color-indigo" style="padding-top: 5px;">
              Entities per page: &nbsp; &nbsp;
            </div>
            <div class="pull-left"><select class="select form-control">
              <option>10</option>
              <option>25</option>
              <option>50</option>
              <option>100</option>
            </select></div>
          </div>
          <ul class="pagination pull-right color-indigo-bordered">
            <li class="disabled"><a href="#"><span class="glyphicon glyphicon-chevron-left"></span></a></li>
            <li class="active"><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-chevron-right"></span></a></li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

  import navbar from './Navbar';

  export default {
    name: 'users',
    data() {
      return {
        msg: 'Welcome to Your Vue.js App',
      };
    },
    components: {
      navbar,
    },
  };
</script>

