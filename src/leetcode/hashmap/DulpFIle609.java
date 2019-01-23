package leetcode.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个目录信息列表，包括目录路径，以及该目录中的所有包含内容的文件，您需要找到文件系统中的所有重复文件组的路径。
 * 一组重复的文件至少包括二个具有完全相同内容的文件。
 * 输入列表中的单个目录信息字符串的格式如下：
 * "root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"
 * 这意味着有 n 个文件（f1.txt, f2.txt ... fn.txt 的内容分别是 f1_content, f2_content ... fn_content）在目录 root/d1/d2/.../dm 下。
 * 注意：n>=1 且 m>=0。如果 m=0，则表示该目录是根目录。
 * 该输出是重复文件路径组的列表。对于每个组，它包含具有相同内容的文件的所有文件路径。文件路径是具有下列格式的字符串：
 * "directory_path/file_name.txt"
 */
public class DulpFIle609 {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String path : paths) {
            String[] files = path.split(" ");
            String base = files[0];
            for (int i = 1; i < files.length; i++) {
                String file = files[i];
                int index = file.indexOf('(');
                String content = file.substring(index);
                if (!map.containsKey(content)) {
                    map.put(content, new ArrayList<>());
                }
                map.get(content).add(base + "/" + file.substring(0, index));
            }
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) {
                res.add(entry.getValue());
            }
        }
        return res;
    }
}
