import java.util.HashMap;
import java.util.Map;


public class MapSample {

	public static void main(String[] args) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		Map<String,String>map = new HashMap<String,String>();

		//�l�̃Z�b�g��put���\�b�h�𗘗p
		map.put("key1","value1");
		map.put("key2","value2");
		map.put("key3","value3");
		map.put("key4","value4");
		map.put("key5","vakue5");
		//�l�̎擾
		String value = map.get("key1");//value1���擾�ł���
		System.out.println(value);

		String valueNull = map.get("key6");//���݂��Ȃ�key�̏ꍇ��null
		System.out.println(valueNull);

		//map�ɊY������key�����݂��邩�ۂ��`�F�b�N���邱�Ƃ��\
		if(map.containsKey("key1")){
			System.out.println("key1�͑��݂��܂�");
		}else{
			System.out.println("key1�͑��݂��܂���");
		}

		//�g��for���𗘗p���Ă��ׂĂ̏����擾����
		for(Map.Entry<String,String>e:map.entrySet()){
			System.out.println(e.getKey() +":"+e.getValue());
		}
	}

}
