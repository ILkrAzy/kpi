export default {
  getProjects() {
    return new Promise((resolve) => {
      const projects = {
        data: ['KPI', 'Sumi', 'Bob'],
      };
      setTimeout(() => {
        resolve(projects);
      }, 100);
    });
  },
};
