package cn.peter.kit;

/**
 * @author Peter Yu 2018/11/27 16:41
 */
public enum FileStatus {

    ADD("A"), DELETE("D"), MODIFY("M"), UN_MODIFIED("U"), UN_SUPPORT("unSupport");

    private String status;

    FileStatus(String status) {
        this.status = status;
    }

    public static FileStatus parse(String status){
        for (FileStatus fileStatus : FileStatus.values()) {
            if (fileStatus.getStatus().equals(status)) {
                return fileStatus;
            }
        }
        return FileStatus.UN_SUPPORT;
    }


    public static boolean isAdd(String status){
        return FileStatus.parse(status).isAdd();
    }
    public static boolean isDelete(String status){
        return FileStatus.parse(status).isDelete();
    }
    public static boolean isModify(String status){
        return FileStatus.parse(status).isModify();
    }
    public static boolean isUnModify(String status){
        return FileStatus.parse(status).isUnModify();
    }
    public static boolean isUnSupport(String status){
        return FileStatus.parse(status).isUnSupport();
    }

    public boolean isAdd() {
        return this.equals(FileStatus.ADD);
    }

    public boolean isDelete() {
        return this.equals(FileStatus.DELETE);
    }

    public boolean isModify() {
        return this.equals(FileStatus.MODIFY);
    }

    public boolean isUnModify() {
        return this.equals(FileStatus.UN_MODIFIED);
    }

    public boolean isUnSupport() {
        return this.equals(FileStatus.UN_SUPPORT);
    }

    public String getStatus() {
        return status;
    }
}
