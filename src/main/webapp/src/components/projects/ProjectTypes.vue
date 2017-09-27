<template>
  <div class="panel">
    <div class="panel-heading">
      <div class="page-header">
        <a href="../project-types.html" class="h3 color-indigo">Project Types</a>
      </div>
      <div class="col-xs-12 col-sm-6 col-md-5">
        <add-project-type></add-project-type>
        <button id="refreshBtn" type="button" class="btn btn-md btn-kpi-default panel-heading-control" @click="getProjectTypes"><span
          class="fa fa-refresh"></span>&nbsp; Refresh
        </button>
      </div>
      <div class="col-xs-12 col-sm-6 col-md-7">
        <div
          class="input-group input-group-md col-xs-12 col-sm-12 col-md-6 pull-right panel-heading-control">
          <input type="text" class="form-control kpi-maincolor-bordered" name="username"
                 placeholder="Search for project types...">
          <div class="input-group-btn">
            <button type="button" class="btn btn-md btn-kpi-default"><span
              class=" fa fa-search"></span></button>
          </div>
        </div>
      </div>
      <div class="clearfix"></div>
    </div>
    <div class="panel-body transperent">
      <div class="row">
        <div v-for="type in types" class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
          <div class="item-box">
            <div class="item-box-heading">
              {{ type.name }}
            </div>
            <div class="item-box-body">
              <div class="col-xs-4">
                <div class="row">
                  <div class="col-lg-12">
                    <div class="col-header">
                      Label
                    </div>
                    <span class="fa fa-tag fa-2x" :class="getLabelClass(type.label)"></span>
                  </div>
                </div>
              </div>
              <div class="col-xs-8">
                <div class="col-header">
                  Projects
                </div>
                VitalQIP CE
                <br/>
                VitalQIP DEV
                <br/>
                VitalQIP QA
              </div>
            </div>
            <div class="item-box-footer">
              <button class="btn btn-md btn-kpi-default-inverse btn-edit-project-type">
                <span class="fa fa-pencil"></span>
              </button>
              <button class="btn btn-md btn-kpi-default-inverse btn-delete-project-type">
                <span class="fa fa-trash"></span>
              </button>

            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

  import { mapGetters, mapActions } from 'vuex';
  import AddProjectType from './AddProjectType';

  export default {
    name: 'projecttypes',
    components: {
      AddProjectType,
    },
    computed: {
      ...mapGetters({
        types: 'allTypes',
      }),
    },
    methods: {
      ...mapActions([
        'getProjectTypes',
      ]),
      getLabelClass(label) {
        return `kpi-label-${label}`;
      },
    },
    created() {
      this.$store.dispatch('getProjectTypes');
    },
  };
</script>

