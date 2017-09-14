<template>
  <span>
    <button id="addProjectTypeBtn" type="button" class="btn btn-md btn-kpi-default panel-heading-control"><span
      class="fa fa-plus-square static-pos"></span>&nbsp; Add Project Type
    </button>
    <div id="newProjectTypeDialog" class="modal fade kpi-dialog" role="dialog">
      <div class="modal-dialog modal-lg">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal"><i class="fa fa-close"></i></button>
            <h4 class="modal-title">Add new Project Type</h4>
          </div>
          <div class="modal-body">
            <div class="row">
              <div class="col-md-12 ">
                <form class="form-horizontal">
                  <fieldset>
                    <div class="form-group">
                      <label class="col-md-4 control-label" for="newProjectTypeDialog_projectTypenameTxt">Project
                        Type Name</label>
                      <div class="col-md-6">
                        <input id="newProjectTypeDialog_projectTypenameTxt" v-model="type.name" name="projectTypeName"
                               type="text"
                               placeholder="Project Type Name"
                               class="form-control input-md kpi-maincolor-bordered" required>
                      </div>
                    </div>
                    <div class="form-group ">
                      <label class="col-md-4 control-label"
                             for="newProjectTypeDialog_labelBox">Label</label>
                      <div class="col-md-6">
                        <select v-model="type.label" id="newProjectTypeDialog_labelBox"
                                class="select form-control kpi-maincolor-bordered" required
                                style="font-family:Helvetica,sans-serif,FontAwesome;">
                          <option class="kpi-label-default" style="font-size: 18px;">&#xf02b; &nbsp;
                            Default
                          </option>
                          <option class="kpi-label-red" style="font-size: 18px;">&#xf02b; &nbsp; Red
                          </option>
                          <option class="kpi-label-blue" style="font-size: 18px;">&#xf02b; &nbsp;
                            Blue
                          </option>
                          <option class="kpi-label-green" style="font-size: 18px;">&#xf02b; &nbsp;
                            Green
                          </option>
                          <option class="kpi-label-purple" style="font-size: 18px;">&#xf02b; &nbsp;
                            Purple
                          </option>
                          <option class="kpi-label-orange" style="font-size: 18px;">&#xf02b; &nbsp;
                            Orange
                          </option>
                        </select>
                      </div>
                    </div>
                    <div class="form-group">
                      <div class="col-md-12 text-center">
                        <button id="newProjectTypeDialog_createBtn" type="submit" v-on:click="add" class="btn btn-success"><span
                          class="fa fa-save"></span>&nbsp;&nbsp;Save
                        </button>
                        &nbsp;
                        <button id="newProjectTypeDialog_clearBtn" type="button" v-on:click="clear" class="btn btn-danger"><span
                          class="fa fa-times-circle"></span>&nbsp;&nbsp;Clear
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
  </span>
</template>
<script>

  import $ from 'jquery';

  function newType() {
    return {
      name: '',
      label: '',
    };
  }

  export default {
    name: 'projecttypes',
    data() {
      return {
        type: newType(),
      };
    },
    methods: {
      add(event) {
        event.preventDefault();
        this.$store.dispatch('add', this.type);
        this.type = newType();
        $('#newProjectTypeDialog').modal('toggle');
      },
      clear() {
        this.type = newType();
      },
    },
    mounted() {
      $('#addProjectTypeBtn').click(() => {
        $('#newProjectTypeDialog').modal({
          backdrop: 'static',
          keyboard: false,
        });
        $('#newProjectTypeDialog_labelBox').prop('selectedIndex', 0);
      });
    },
  };
</script>

